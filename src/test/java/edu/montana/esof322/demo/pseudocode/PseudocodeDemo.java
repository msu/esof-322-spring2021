package edu.montana.esof322.demo.pseudocode;

import edu.montana.esof322.model.MSUClass;
import edu.montana.esof322.model.User;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.PathMap;

import java.util.HashSet;
import java.util.LinkedList;
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


    // Find All Advisors For An MSU Class by Class ID
    List<User> findAllAdvisorsForMSUClass(Integer msuClassId) {
        // Look up the class
        MSUClass msuClass = MSUClass.find(msuClassId);
        Set<User> advisors = new HashSet<>();
        // For each student in the class
        for (User student : msuClass.getUsers()) {
            //   collect the advisor for that student into a set
            Long advisorId = student.adv;
            User advisor = User.find(advisorId);
            advisors.add(advisor);
        }
        // Return the set of advisors
        LinkedList<User> advisorsAsList = new LinkedList<>(advisors);
        return advisorsAsList;
    }

}
