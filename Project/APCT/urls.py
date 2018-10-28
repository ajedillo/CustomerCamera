
from django.conf.urls import url
from django.urls import path

from . import views

urlpatterns = [
#          url(r'^$', views.index, name='index'),
#          url(r'^$', views.HomePageView.as_view()),
#          url(r'^about/$', views.AboutPageView.as_view()),
            path('signup/', views.SignUp.as_view(), name='signup'),
            path('', views.home.as_view(), name='home'),
            path('about/', views.about.as_view(), name='about'),
            path('layout/', views.layout.as_view(), name='layout'),
          ]
