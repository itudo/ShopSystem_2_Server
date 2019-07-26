<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	request.setAttribute("basePath", basePath);
%>
<base href="${basePath }">
<!-- <link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.5.4.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.5.4.5/themes/icon.css"> -->

 
<!-- <script type="text/javascript"
	src="../jquery-easyui-1.5.4.5/jquery.min.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script> -->
 
	
	<!-- <script src="../plupload-3.1.2/js/plupload.full.min.js"></script> -->
	
<!-- <script type="text/javascript"
	src="../jquery-easyui-1.5.4.5/themes/default/easyui.css"></script>

<script type="text/javascript"
	src="../jquery-easyui-1.5.4.5/themes/icon.css"></script>

<script type="text/javascript"
	src="../jquery-easyui-1.5.4.5/demo/demo.css"></script> -->
	
	 
 
 
	<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.5.4.5/demo/demo.css"> 
	<!-- 布局 -->
	
	<link rel="stylesheet" type="text/css"
	href="../EasyUI-1.5.1-InsdepTheme-1.0.1/themes/insdep/easyui.css"> 
	
	<link rel="stylesheet" type="text/css"
	href="../EasyUI-1.5.1-InsdepTheme-1.0.1/themes/insdep/easyui_animation.css"> 
	
	<link rel="stylesheet" type="text/css"
	href="../EasyUI-1.5.1-InsdepTheme-1.0.1/themes/insdep/easyui_plus.css"> 
	
	<link rel="stylesheet" type="text/css"
	href="../EasyUI-1.5.1-InsdepTheme-1.0.1/themes/insdep/insdep_theme_default.css"> 
	
	<link rel="stylesheet" type="text/css"
	href="../EasyUI-1.5.1-InsdepTheme-1.0.1/themes/insdep/icon.css"> 
	
	<script type="text/javascript"
	src="../EasyUI-1.5.1-InsdepTheme-1.0.1/jquery.min.js"></script>

	<script type="text/javascript"
	src="../EasyUI-1.5.1-InsdepTheme-1.0.1/jquery.easyui.min.js"></script>

	<script type="text/javascript"
	src="../EasyUI-1.5.1-InsdepTheme-1.0.1/themes/insdep/jquery.insdep-extend.min.js"></script>
	
	
	
	<script type="text/javascript"
	src="../EasyUI-1.5.1-InsdepTheme-1.0.1/themes/dateview.js"></script>