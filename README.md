# CustomerCamera
CSI 4999 - Senior Capstone
APCT - All-Purpose Customer Tracker

# Group Members
Richard Clemence, Andrew Edillo, Evan Kennedy, Chad Schulte, Sagar Tailor, Kip Tucker

**WEBSITE INSTALL INSTRUCTIONS**

Install instructions:
Install Bitnami Django stack by following the tutorial at :https://docs.bitnami.com/google/infrastructure/django/

Run Following commands at ../Project/ level or where manage.py is present:

sudo python3 manage.py startapp 'APCT'

After structure of 'app' is constructed by the framework, copy paste source code at APCT folder and Project folder.

Run following commands to sync the changes:

Python3 manage.py makemigrations
python3 manage.py migrate
python3 manage.py runserver.
Python3 manage.py createsuperuser
enter credentials

Then navigate to 127.0.0.1:8080 to view the homepage
Login with previous created credentials.

** CAMERA SOLUTION INSTALL INSTRUCTIONS**

Requirements:

1. JDK 11
2. Eclipse Java IDE
3. JUnit 4.12
4. OpenCV 4.0.0
5. Source folder

Installation:

1. Ensure build path in Eclipse references JUnit 4.12 and OpenCV 4.0.0
2. Open source folder with Eclipse, choosing the 'master' directory as the project file
3. Run file main, adjust input as needed
