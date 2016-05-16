package ru.nefrosovet.nsequipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EquipmentSrvController {

    private static final Logger log = LoggerFactory.getLogger(EquipmentSrvController.class);

    @RequestMapping(value="/help")
    public String[] help()
    {
        String usage[] = {"machine", "task"};
        return usage;
    }

    @RequestMapping(value="/help/{context}")
    public String[] help_context(@PathVariable("context") String context)
    {
        if (context.equals("machine"))
        {
            String usage[] = {"machine_id", "machine_type", "machine_subtype"};
            return usage;
        } if (context.equals("task")) {
            String usage[] = {"none"};
            return usage;
        }
        return null;
    }

    @RequestMapping("/machine")
    public List<Machine> machine(@RequestParam(value="machine_id", defaultValue="") String machineId,
                                 @RequestParam(value="machine_type", defaultValue="") String machineType,
                                 @RequestParam(value="machine_subtype", defaultValue="") String machineSubType
    )
    {
        JdbcTemplate jdbc = DatabaseController.getJdbc();

        String sql = String.format("EXEC spPhysicalMachineListOverallView %s, null, %s, %s",
                machineId.isEmpty() ? "null" : machineId,
                machineSubType.isEmpty() ? "null" : machineSubType,
                machineType.isEmpty() ? "null" : String.format("'%s'", machineType)
        );

        List<Machine> ret = jdbc.query(
                sql,
                new Object[] {},
                (rs, row1Num) -> new Machine(
                        rs.getString("PhysMachineName"),
                        rs.getString("SerialNumber"),
                        rs.getString("PhysMachineStatusName"),
                        rs.getString("RoomName"),
                        rs.getString("BedName")
                )
        );
//        ret.forEach(machine -> log.info(machine.toString()));
        return ret;
    }

}
