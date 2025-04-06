import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';
import { Product } from '../model/product';
import { ProductCardComponent } from './product-card/product-card.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-list',
  imports: [ProductCardComponent,CommonModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  constructor(private axiosService: AxiosService) {}

  products: Product[] = [];

  ngOnInit(): void {
    this.fetchProducts();
  }

  fetchProducts(): void {
    this.axiosService.request("GET", "/products", {}) 
      .then(response => {
        this.products = response.data; 
        console.log("Product data " + this.products.length);
      })
      .catch(error => {
        console.error("Error fetching products:", error);
      });
  }

}
