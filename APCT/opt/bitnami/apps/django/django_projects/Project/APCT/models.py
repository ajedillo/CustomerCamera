from django.db import models

# Create your models here.
class Store(models.Model):
    store_name = models.CharField(max_length=200)
    location = models.CharField(max_length=200)

    # Methods
    def get_absolute_url(self):
        """Returns the url to access a particular instance of MyModelName."""
        return reverse('store-view', args=[str(self.id)])
    
    def __str__(self):
        """String for representing the MyModelName object (in Admin site etc.)."""
        return self.store_name

class Product(models.Model):
    """Model representing a Language (e.g. English, French, Japanese, etc.)"""
    product_name = models.CharField(max_length=200, help_text="Product name")

    def __str__(self):
        """String for representing the Model object (in Admin site etc.)"""
        return self.product_name
      
class Camera(models.Model):
    """Model representing a Language (e.g. English, French, Japanese, etc.)"""
    camera_view = models.CharField(max_length=200, help_text="Aerial, overhead..")
    camera_location=models.CharField(max_length=200)

    def __str__(self):
        """String for representing the Model object (in Admin site etc.)"""
        return self.camera_view

class Aisle(models.Model):
    aisle_number = models.IntegerField()
    aisle_name = models.CharField(max_length=200)
    aisle_description = models.CharField(max_length=200)
    store = models.ForeignKey('Store', on_delete=models.SET_NULL, null=True)
    product = models.ManyToManyField(Product, help_text="Select products in this aisle")
    camera = models.ManyToManyField(Camera, help_text="cameras this aisle has")

    def get_absolute_url(self):
        """Returns the url to access a particular instance of MyModelName."""
        return reverse('aisle-view', args=[str(self.id)])
    
    def __str__(self):
        """String for representing the MyModelName object (in Admin site etc.)."""
        return self.aisle_name

