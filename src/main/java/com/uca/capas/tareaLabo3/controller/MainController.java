package com.uca.capas.tareaLabo3.controller;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/alumno")
	public @ResponseBody String infoalumno() {

		return ("Informacion del alumno: <br/> " + "Nombre: Roberto <br/>" + "Apellido: Fuentes <br/>"
				+ "Carrera: Ingenieria Informatica <br/>" + "Año: 4 ");
	}

	@RequestMapping("/parametros")
	public @ResponseBody String parametro(HttpServletRequest request) {
		Integer nday = Integer.parseInt(request.getParameter("dia"));
		Integer nmonth = Integer.parseInt(request.getParameter("mes"));
		Integer anio = Integer.parseInt(request.getParameter("anio"));
		String dias[] = { " Domingo ", " Lunes ", " Martes ", " Miercoles ", " Jueves ", " Viernes ", " Sabado " };
		int d = 0;
		if ((nday < 32) && (nmonth < 13) && (anio < 10000)) {
			int a = (14 - nmonth) / 12;
			int y = anio - a;
			int m = nmonth + 12 * a - 2;
			d = (nday + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

			
		}
		return "Dia de la semana es: " + dias[d];
	}
}
