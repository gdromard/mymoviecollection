<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/> 
	<title><decorator:title default="Struts Starter"/></title>
    <decorator:head/>
    <link href="<s:url value='/resources/styles/main.css'/>" rel="stylesheet" type="text/css" media="all"/>
    <link href="<s:url value='/struts/niftycorners/niftyCorners.css'/>" rel="stylesheet" type="text/css"/>
    <link href="<s:url value='/struts/niftycorners/niftyPrint.css'/>" rel="stylesheet" type="text/css" media="print"/>
    <script language="JavaScript" type="text/javascript" src="<s:url value='/struts/niftycorners/nifty.js'/>"></script>
	<script language="JavaScript" type="text/javascript">
        window.onload = function(){
            if(!NiftyCheck()) {
                return;
            }
            // perform niftycorners rounding
            // eg.
            //Rounded("blockquote","tr bl","#ECF1F9","#CDFFAA","smooth border #88D84F");
        }
    </script>
    <style type="text/css">
    	body { behavior: url(<s:url value='/resources/styles/csshover.htc'/>); }
    </style>
</head>
<body id="page-home">
    <div id="page">
		<div id="header">
			<table class="design"><tr><td class="left"></td>
			<td class="middle">
		        <div class="content">
    		    	My Movie Collection
        		</div>
        
	       		<div id="search">
		        	Search
            	</div>
		        <div id="branding">
		        	Branding
		        </div>
			</td><td class="right"></td></tr></table>
		</div>
		<div id="content">
			<table class="design"><tr><td class="left"></td>
			<td class="middle">
		        <div class="content" class="clearfix">
		            <div id="main">
		            	<decorator:body/>
		            </div>
            
            <div id="sub">
            	<h3>Sub Content</h3>
            </div>
            
            <div id="local">
                <h3>Local Nav. Bar</h3>
                <ul>
                    <li><a href="#">Content page 1</a></li>
                    <li><a href="#">Content page 2</a></li>
                    <li><a href="#">Content page 3</a></li>
                    <li><a href="#">Content page 4</a></li>
                    <li><a href="#">Content page 5</a></li>
                    <li><a href="#">Content page 6</a></li>
                </ul>
            </div>
            
            
            <div id="nav">
                <div class="wrapper">
	                <h3>Nav. bar</h3>
	                <ul class="clearfix">
	                     <li><a href="<s:url action='list'/>">Movies</a></li>
	                     <li><a href="<s:url action='search'/>">Search</a></li>
	                </ul>
                </div>
                <hr />
            </div>
	        </div>
				</td><td class="right"></td></tr></table>
			</div>
			<div id="footer">
				<table class="design"><tr><td class="left"></td><td class="middle">
				<div class="content">
		            Footer
		        </div>
				</td><td class="right"></td></tr></table>
		    </div>
		</div>
    
	    <div id="extra1">&nbsp;</div>
	    <div id="extra2">&nbsp;</div>
	</body>
</html>
