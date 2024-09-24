<%-- 
    Document   : Register.jsp
    Created on : May 12, 2022, 3:50:52 PM
    Author     : sadhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EMS</title>
        <link rel="stylesheet" href="style.css"> 
        <script>
            function validateAllFields(){
            var pwd=document.getElementById("pwd").value;
            var cpwd=document.getElementById("cpwd").value;
           
            if(pwd!==cpwd){
                alert("Password and confirm password doesnt match!");
                return false;
            }
            
            return true;
            }
            
            function dispForm(){
                var f2=document.getElementById("loginForm");
                f2.style.display='block';
            }
        </script>
    </head>
    <body>
        <header class="banner">
            <h1>Employee Management System</h1>
        </header>
        <nav>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="./Register.jsp">Register</a></li>
        <li><a href="index.html">Login</a></li>
        <li><a href="contact.html">Contact</a></li>
        <li><a href="about.html">About us</a></li>
      </ul>
    </nav>
        <main>
      <section>
        <h2>Employee Registration</h2>
        <div id="form1">
        <form  name="f2" method="post" action="./RegistrationServ">
            <fieldset>
                <legend> Register Here </legend>
                <br>
                  <label for name="id"> Employee ID</label>
                  <input type="number" id="eid" name="eid" placeholder="enter EMP ID" required>
                <br> <br>
                 <label for name="name"> Employee User Name</label>
                 <input type="text" id="name" name="name" placeholder="enter name" required>
                 <br> <br>
                 <label for name="pwd"> Password</label>
                 <input type="password" id="pwd" name="pwd" placeholder="enter password" required>
                 <br> <br>
                 <label for name="cpwd"> Confirm Password</label>
                 <input type="password" id="cpwd" name="cpwd" placeholder="confirm password" required>
                 <br> <br>
                <label for name="email"> Email ID</label>
                <input type="text" id="email" name="email" placeholder="enter email" required="">
                <br> <br>
                <label for name="mobile"> Mobile Number</label>
                <input type="number" id="mobile" name="mobile" placeholder="enter mobile" required="">
                <br>
                <br>
                 <input type="submit" id="submit" value="Register" onclick="return validateAllFields()">
                 <input type="reset" id="reset" value="Clear">
            </fieldset>   
        </form>
        </div>
      </section>
    </main>
        <aside>
            <h2> Already Registered?</h2>
         <button id="btn1" name="login" onclick="dispForm()">Click here to Login!</button>
         <div id="loginForm" style="display:none"> 
          <br>
      <form name="f1" method="post" action="./LoginServ">
          
       <label> User Name</label>
       <input type="text" id="name" name="name" placeholder="uname" required>
       <br> <br>
       <label > Password</label>
       <input type="password" id="pwd" name="pwd" placeholder="password" required>
       <br> <br> <br>
       <input type="submit" id="submit" value="Login" >
      </form>

    </aside>
    <footer>
      <p>EMS@2022 All rights reserved @SSR</p>
    </footer>
    </body>
</html>
