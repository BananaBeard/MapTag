package com.maptag.location;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/coordservlet")
public class CoordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MapTagUtil mapTagUtil = new MapTagUtil();
        try {
            ArrayList<ServerCoordinates> coordinates = mapTagUtil.getCoordinatesFromFolder("../resources/Addresses");
            req.setAttribute("addrs", coordinates);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            if (dispatcher != null) {
                dispatcher.forward(req, resp);
            }
            } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }
    }
}
