package edu.montana.esof322;

import edu.montana.esof322.util.Web;
import edu.montana.esof322.controller.*;

import static spark.Spark.*;

class Server {

    public static void main(String[] args) {

        /* ========================================================================= */
        /* Poor Mans Rails Implementation                                            */
        /* ========================================================================= */
        Web.init();

        /* ========================================================================= */
        /* Root Path                                                                 */
        /* ========================================================================= */
        get("/", (req, resp) -> {
            Web.message("Software Engineering Is Awesome");
            return templates.index.render();
        });

        /* ========================================================================= */
        /* Business
        /* ========================================================================= */
        UsersController.init();
        MSUClassesController.init();

    }

}