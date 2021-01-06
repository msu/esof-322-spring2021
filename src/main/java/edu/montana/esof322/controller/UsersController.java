package edu.montana.esof322.controller;

import edu.montana.esof322.helpers.UserHelper;
import edu.montana.esof322.model.User;
import edu.montana.esof322.util.Web;

import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class UsersController {
    public static void init(){
        /* CREATE */
        get("/users/new", (req, resp) -> {
            User user = new User();
            return Web.renderTemplate("templates/users/new.vm", "user", user);
        });

        post("/users/new", (req, resp) -> {
            User emp = new User();
            Web.putValuesInto(emp, "FirstName", "LastName");
            if (emp.create()) {
                Web.message("Created An User!");
                return Web.redirect("/users/" + emp.u_id);
            } else {
                Web.error("Could Not Create An User!");
                return Web.renderTemplate("templates/users/new.vm",
                        "user", emp);
            }
        });

        /* READ */
        get("/users", (req, resp) -> {
            Integer page = Web.getPage();
            List<User> users = User.all(page, Web.PAGE_SIZE);
            return Web.renderTemplate("templates/users/index.vm",
                    "users", users);
        });

        get("/users/instructors", (req, resp) -> {
            Integer page = Web.getPage();
            List<User> users = User.getInstructors();
            return Web.renderTemplate("templates/users/index.vm",
                    "users", users);
        });

        get("/users/:id", (req, resp) -> {
            User user = User.find(Integer.parseInt(req.params(":id")));
            return Web.renderTemplate("templates/users/show.vm",
                    "user", user);
        });

        /* UPDATE */
        get("/users/:id/edit", (req, resp) -> {
            User user = User.find(Integer.parseInt(req.params(":id")));
            return Web.renderTemplate("templates/users/edit.vm",
                    "user", user);
        });

        post("/users/:id", (req, resp) -> {
            User emp = User.find(Integer.parseInt(req.params(":id")));
            Web.putValuesInto(emp, "FirstName", "LastName");
            if (emp.update()) {
                Web.message("Updated User!");
                return Web.redirect("/users/" + emp.u_id);
            } else {
                Web.error("Could Not Update User!");
                return Web.renderTemplate("templates/users/edit.vm",
                        "user", emp);
            }
        });

        /* DELETE */
        get("/users/:id/delete", (req, resp) -> {
            User user = User.find(Integer.parseInt(req.params(":id")));
            user.delete();
            Web.message("Deleted User " + user.em);
            return Web.redirect("/users");
        });
    }
}
