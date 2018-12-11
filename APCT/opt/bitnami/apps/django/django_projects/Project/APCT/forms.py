from django.core.exceptions import ValidationError
from django.utils.translation import ugettext_lazy as _
import datetime  # for checking renewal date range.
    
from django import forms
from .models import Camera, Aisle, Store, Product

class AddCameraForm(forms.ModelForm):
      
  class Meta:
    model = Camera
    fields = ('camera_view', 'camera_location',)

class AddAisleForm(forms.ModelForm):
      
  class Meta:
    model = Aisle
    fields = ('aisle_number', 'aisle_name','aisle_description','store',)

class AddProductForm(forms.ModelForm):
      
  class Meta:
    model = Product
    fields = ('product_name',)