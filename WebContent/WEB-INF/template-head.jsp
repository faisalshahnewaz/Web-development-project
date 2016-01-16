<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 08-672 J2EE Web Application Development.
@author Xuesong Zhang (Andrew ID: xuesongz)
November 30th, 2015 -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Favorites Tool</title>
        <style type="text/css">
        	body{
				margin:0px;
				padding:0px;
				overflow:hidden;
			}
			#header{
				height:100px;
				width:100%;
			} 
			#heading{
				position:relative;
				float:left;
				margin-left:20%;
				margin-top:-18px;
				height:110px;
				width:60%;
				border-radius: 18px;
				background-color: #E0E0E0;
				opacity:0.6;
			}
			#heading #title{
				margin-top:40px;
				text-align:center;
				font-size:24px;
				font-weight:bold;
			}
			#heading #subTitle{
				margin-top:10px;
				text-align:center;
				font-family:Courier New;
			}
			#mainPanel{
			    position:relative;
				margin:25px;
				height:450px;
			    border-radius: 18px;
			    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
			    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
			}
			#welcome{
				margin-top:20px;
				height:60px;
				width:100%;
				vertical-align: middle;
				display: inline-block;
				line-height: 60px;
				text-align:center;
			}
			#welcome #welcome-text{
				font-size:38px;
				font-weight:bold;
				text-shadow: 0 1px 1px #F6F6F6;
			}
			.centertable {
            	margin: 20px auto;
            }
			.form-input{
				height:20px;
			}
			.btn{
			    border:1px solid #cccccc;
			    cursor:pointer;
			    margin:10px 5px;
			    height:40px;
				width:80px;
			    text-align:center;
			    border-radius: 4px;
			    border-color: #636263 #464647 #A1A3A5;
			    text-shadow: 0 1px 1px #F6F6F6;
			    background-image: -moz-linear-gradient(center top, #D9D9D9, #A6A6A6 49%, #A6A6A6 50%);
			    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #D9D9D9),color-stop(1, #A6A6A6));
			}
			#errormsg {
				text-align:center;
				color:red
			} 
			#logout{
			    position: relative;
				float:right;
			}
			.favoritetable {
            	border-width: 2px;
            	border-style: dotted;
            	border-color: black; 
            	margin: 20px auto;
            	background-color: #EEE;
            }
            #maintitle{
				font-size:50px;
				font-weight:bold;
				text-shadow: 0 1px 1px #F6F6F6;
			}     
			.menu-item{
				font-size:16px;
				/* font-weight:bold; */
				text-shadow: 0 1px 1px #F6F6F6;
			}  
			.menu-item a{
				text-decoration:none;
				color:black
			} 
			.menu-item a:hover{
				/* text-decoration:underline; */
				background-color: #E1E1E1;
			}   
			.menu-head{
				font-size:20px;
				font-weight:bold;
				text-shadow: 0 1px 1px #F6F6F6;
			}  
		</style>
    </head>