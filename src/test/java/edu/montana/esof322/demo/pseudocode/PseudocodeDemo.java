package edu.montana.esof322.demo.pseudocode;

import edu.montana.esof322.model.MSUClass;
import edu.montana.esof322.model.User;
import org.eclipse.jetty.http.HttpFields;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PseudocodeDemo {

    // BAD Pseudocode
    //
    // increment resource number by 1
    // construct a dlg struct using factory
    // if factory returns NULL then return 1
    // invoke osrSrcInit to initialize a resource for the operating system
    // intRscNum = resource number
    // return 0

    // Good Pseudocode
    //
    // Keep track of current number of resources in use
    // If another resource is available
    //   Create a dialog box
    //   If a dialog box could be created
    //     Note that one more resource is in use
    //     Initialize the resource
    //     Store the resource number at the location provided by the caller
    //   Endif
    // Endif
    // Return true if a new resource was created; else return false

    // Pseudocode --> Code
    //
    // Find All Advisors For An MSU Class by ID
    //
    // Look up the class
    // For each student in the class
    //   collect the advisor for that student into a set
    // Return the set of advisors

}
