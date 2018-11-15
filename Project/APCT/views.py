from django.shortcuts import render
from django.views.generic import TemplateView
# Create your views here.
from django.http import HttpResponse
from django.contrib.auth.forms import UserCreationForm
from django.urls import reverse_lazy
from django.views import generic

#def index(request):
#     return HttpResponse("Hello world!amanada is butt head")

#class HomePageView(TemplateView):
#        def get(self, request, **kwargs):
#                    return render(request, 'index.html', context=None)

#class AboutPageView(TemplateView):
#        template_name = "about.html"

class SignUp(generic.CreateView):

        form_class = UserCreationForm
        success_url = reverse_lazy('login')
        template_name = 'signup.html'

class about(generic.CreateView):
        form_class = UserCreationForm
        success_url = reverse_lazy('about')
        template_name = 'about.html'

class house(generic.CreateView):
            form_class = UserCreationForm
            success_url = reverse_lazy('about')
            template_name = 'house.html'

class layout(generic.CreateView):
        form_class = UserCreationForm
        success_url = reverse_lazy('about')
        template_name = 'layout.html'

class dashboard(generic.CreateView):
        form_class = UserCreationForm
        success_url = reverse_lazy('house')
        template_name = 'dashboard.html'


