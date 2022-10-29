package service;

import Model.Admin;

public class AdminService {
    Admin admin;
    public Admin addAdmin(String name, String id)
    {
        admin=new Admin(name,id);
        return admin;
    }
}
