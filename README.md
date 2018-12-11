# CustomerCamera
CSI 4999 - Senior Capstone
APCT - All-Purpose Customer Tracker

# Group Members
Richard Clemence, Andrew Edillo, Evan Kennedy, Chad Schulte, Sagar Tailor, Kip Tucker

**CHANGELOG**

13 September 2018
Added members, documents/research folder

11 September 2018
Created Github repo
Web Front end installation.

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
