import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AxiosService } from '../../axios.service';
import { Product } from '../../model/product';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CarouselModule } from 'ngx-owl-carousel-o';

@Component({
  selector: 'app-product-detail',
  imports: [CommonModule,FormsModule,CarouselModule],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent {

  productId: string = '';
  product!: Product;
  quantity: number = 1;
  colorMap = {
    'BLACK': 'ดำ',
    'RED': 'แดง',
    'BLUE': 'น้ำเงิน',
    'GREEN': 'เขียว',
    'WHITE': 'ขาว',
  };
  selectedColor: string = '';

  carouselImages: string[] = [
    'banner-1.jpg',
    'banner-2.jpg',
    'banner-3.jpg'
  ];

  carouselOptions: any = {
    loop: true,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: false,
    navSpeed: 1000,  
    navText: ['', ''],
    responsive: {
      0: {
        items: 3
      },
      400: {
        items: 3
      },
      740: {
        items: 3
      },
      940: {
        items: 3
      }
    },
    nav: false,
    autoplay: false,          
    autoHeight: false
  };



  constructor(
    private route: ActivatedRoute,
    private axiosService: AxiosService
  ) {}

  decreaseQuantity() {
    if (this.quantity > 1) {
      this.quantity -= 1;
    }
  }

  increaseQuantity() {
    if (this.quantity < this.product.productStock) {
      this.quantity += 1;
    }
  }

  onQuantityChange() {
    if (this.quantity > this.product.productStock) {
      this.quantity = this.product.productStock;
    }
  }


  ngOnInit(): void {
    this.productId = this.route.snapshot.paramMap.get('id') || '';
    this.fetchProductDetails(this.productId);
  }

  selectColor(color: string): void {
    this.selectedColor = color;
  }

  getColorName(color: string): string {
    return this.colorMap[color.toUpperCase() as keyof typeof this.colorMap] || color;
  }

  fetchProductDetails(id: string): void {

    this.axiosService.request("GET", `/products/${id}`, {})
      .then(response => {
        this.product = response.data;
        this.selectColor(this.product.productColor.split(",")[0]);
      })
      .catch(error => {
        console.error('Error fetching product details', error);
      });
  }

}
