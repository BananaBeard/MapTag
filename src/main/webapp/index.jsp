<%@ page import="com.maptag.location.MapTagUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.maptag.location.ServerCoordinates" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Control positioning</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        #map {
            height: 100%;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>
<%--<iframe src="//www.google.com/maps/embed/v1/place?q=Empire%20State%20Building
      &zoom=13
      &attribution_source=Google+Maps+Embed+API
      &attribution_web_url=https://developers.google.com/maps/documentation/embed/
      &key=AIzaSyDY-WR5RAUy48X0gCegD7qrQag4SqckB9w" allowfullscreen >
</iframe>--%>
<div id="map"></div>
<script>
    var 
    function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: {lat: -28.643387, lng: 153.612224},
            mapTypeControl: true,
            mapTypeControlOptions: {
                style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
                position: google.maps.ControlPosition.TOP_CENTER
            },
            zoomControl: true,
            zoomControlOptions: {
                position: google.maps.ControlPosition.LEFT_CENTER
            },
            scaleControl: true,
            streetViewControl: true,
            streetViewControlOptions: {
                position: google.maps.ControlPosition.LEFT_TOP
            },
            fullscreenControl: true
        });
        <c:forEach items="${addrs}" var="item">
 var myLatLng = {${item.latitude}, ${item.longitude}};
 var marker = new google.maps.Marker({
     position: myLatLng,
     map: map,
     title: 'Hello World!'
 });
 </c:forEach>
    }
</script>
<script async defer
 src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCapyxcJWT8XDuReEakbvFbVksfCPC00NE&callback=initMap">
</script>
</body>
</html>
