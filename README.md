# CustomerCamera
CSI 4999 - Senior Capstone
APCT - All-Purpose Customer Tracker

# Group Members
Richard Clemence, Andrew Edillo, Evan Kennedy, Chad Schulte, Sagar Tailor, Kip Tucker

**WEBSITE INSTALL INSTRUCTIONS**

Requirements:
1. Google Cloud Account
2. Google Cloud Server
3. Bitnami Django (tutorial:https://docs.bitnami.com/google/infrastructure/django/)
4. Project Source Code

Installation:
Run Following commands at ../Project/ level or where manage.py is present:
1. `sudo python3 manage.py startapp 'APCT''
2. After structure of 'app' is constructed by the framework, copy paste source code at APCT folder and Project folder.

Run following commands to sync the changes:
1. `python3 manage.py makemigrations`
2. `python3 manage.py migrate`
3. `python3 manage.py runserver.`
4. `python3 manage.py createsuperuser`
5. enter credentials
6. navigate to 127.0.0.1:8080 to view the homepage
7. Login with previous created credentials.

**CAMERA SOLUTION INSTALL INSTRUCTIONS**

Requirements:
1. JDK 11
2. Eclipse Java IDE
3. JUnit 4.12
4. OpenCV 4.0.0
5. Source folder

Installation:
1. Ensure build path in Eclipse references JUnit 4.12 and OpenCV 4.0.0
2. Open source folder with Eclipse, choosing the 'master' directory as the project file
3. Run file main, adjust video input as needed at CONFIG.java
