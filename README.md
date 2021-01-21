# ESOF 322 - Software Engineering

This is the base upstream repository for ESOF 322.  It will be used for code-related homework and general
 exploration in the class.

Students will be working pairs for 322.  Please nominate one person as the project leader who
will maintain the repository that you both use for implementing your project.

## Getting Your Repo Set Up

For the project leader, please follow these instructions

- Create a *private* repository in your own account by
    - Going to <https://github.com/new>
    - Enter the name `esof-322-fall2020-private`
    - Select `Private`
    - Navigate to the `Settings` -> `Manage Access` section
    - Add `1cg` as a collaborator
    - Add your partner as a collaborator

Once your repository is initialized, you and your partner can pull it down to your local machines.  Instructions can
be found on the home page of your new repository.

Next, you and your partner should both add the class repository as an upstream git repo:

```bash
$ git remote add upstream https://github.com/msu/esof-322-spring2021.git
$ git pull upstream master
$ git push origin master
```
This will synchronize your private repository with the class repository.

When you want to get an update from the public class repository you can run this command:

```
$ git pull upstream master
```

### Web Application

This repository contains a java-based web application that we will be using for demonstrations and homework.  You
can start the web application from IntelliJ by going to the Server.java file and right clicking inside the 
main function, and selecting run or debug.

### Web Application Resources

* [Spark Java Docs](http://sparkjava.com/documentation)
* [Velocity Templates Docs](https://velocity.apache.org/engine/2.2/user-guide.html#loops)
