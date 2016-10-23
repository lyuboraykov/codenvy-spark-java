# codenvy-spark-java
Template for starting a new workspace in Codenvy with Java, Maven, Sparkjava and MySQL

To setup the project after creating a workspace:

1. Click on `Swith to Operations Perspective`
(The small button on the top right corner with the 3 cubes on it)

2. Go to machine `db` -> tab `servers` and write down the URL of `Server Address`

3. Go to machine `dev-machine` -> tab `servers` and write down the URL of the last `Server Address`, port 4567

4. Switch back to `Project Perspective` the tag button on the top right, next to the first one

5. Go to the `Main.java` class file and `main` method. Edit the `DB_URL` with the first address you wrote down.

6. Go to `Run` -> `Edit Commands` on the top menu.

7. If there's no `Execute` command in the Maven section, add one.
The command should be `clean install exec:java`. Save it.

8. Run the `Execute command` and access your app at the second Address you wrote down.

