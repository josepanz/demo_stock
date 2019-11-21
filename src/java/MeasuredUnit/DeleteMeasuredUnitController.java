/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeasuredUnit;

import DataBase.ConnectionDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NITRO 5
 */
public class DeleteMeasuredUnitController {

    private JdbcTemplate jdbcTemplate;

    public DeleteMeasuredUnitController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
    }

    @RequestMapping("deleteMeasuredUnit.htm")
    public ModelAndView deleteCountry(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update("DELETE FROM measured_unit where id=?", id);
        return new ModelAndView("redirect:/measuredUnit.htm");
    }
}
