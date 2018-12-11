from django.contrib import admin

# Register your models here.

from APCT.models import Camera, Aisle, Product, Store

admin.site.register(Camera)
admin.site.register(Aisle)
admin.site.register(Product)
admin.site.register(Store)
