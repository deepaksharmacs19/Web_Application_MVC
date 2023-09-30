package com.thinking.machines.hr.dl;

public class AdministratorDTO implements java.io.Serializable
{
String username;
String password;

AdministratorDTO(String username,String password)
{
this.username=username;
this.password=password;
}

public void setUsername(String username)
{
this.username=username;
}

public void setPassword(String password)
{
this.password=password;
}

public String getUsername()
{
return this.username;
}

public String getPassword()
{
return this.password;
}

public String toString()
{
return this.username+" "+this.password;
}
}