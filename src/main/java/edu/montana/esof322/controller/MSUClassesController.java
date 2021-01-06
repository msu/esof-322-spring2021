package edu.montana.esof322.controller;

import edu.montana.esof322.model.MSUClass;
import edu.montana.esof322.model.User;
import edu.montana.esof322.util.Web;

import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class MSUClassesController {
    public static void init(){
        /* CREATE */
        get("/classes/new", (req, resp) -> {
            MSUClass msuClass = new MSUClass();
            return Web.renderTemplate("templates/classes/new.vm", "msuClass", msuClass);
        });

        post("/classes/new", (req, resp) -> {
            MSUClass emp = new MSUClass();
            Web.putValuesInto(emp, "Name", "Title");
            if (emp.create()) {
                Web.message("Created A Class!");
                return Web.redirect("/classes/" + emp.getMSUClassId());
            } else {
                Web.error("Could Not Create A Class!");
                return Web.renderTemplate("templates/classes/new.vm",
                        "user", emp);
            }
        });

        /* READ */
        get("/classes", (req, resp) -> {
            List<MSUClass> classes = MSUClass.all(1, Web.PAGE_SIZE);
            return Web.renderTemplate("templates/classes/index.vm",
                    "msuClasses", classes);
        });

        get("/classes/:id", (req, resp) -> {
            MSUClass msuClass = MSUClass.find(Integer.parseInt(req.params(":id")));
            return Web.renderTemplate("templates/classes/show.vm",
                    "msuClass", msuClass);
        });

        /* UPDATE */
        get("/classes/:id/edit", (req, resp) -> {
            MSUClass msuClass = MSUClass.find(Integer.parseInt(req.params(":id")));
            return Web.renderTemplate("templates/classes/edit.vm",
                    "msuClass", msuClass);
        });

        post("/classes/:id", (req, resp) -> {
            MSUClass msuClass = MSUClass.find(Integer.parseInt(req.params(":id")));
            Web.putValuesInto(msuClass, "FirstName", "LastName");
            if (msuClass.update()) {
                Web.message("Updated MSUClass!");
                return Web.redirect("/classes/" + msuClass.getMSUClassId());
            } else {
                Web.error("Could Not Update MSUClass!");
                return Web.renderTemplate("templates/classes/edit.vm",
                        "msuClass", msuClass);
            }
        });

        /* DELETE */
        get("/classes/:id/delete", (req, resp) -> {
            MSUClass msuClass = MSUClass.find(Integer.parseInt(req.params(":id")));
            msuClass.delete();
            Web.message("Deleted MSUClass " + msuClass.getTitle());
            return Web.redirect("/classes");
        });
    }
}
