import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
 selector: 'PaymentComp',
 templateUrl: './PaymentComp.html',
 styleUrls: ['./PaymentComp.scss'],
 standalone: true,
 imports: [CommonModule, RouterOutlet],
 providers: [],
})
export class PaymentComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }
}