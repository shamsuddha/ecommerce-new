import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComp } from './header/HeaderComp';
import { FooterComp } from './footer/FooterComp';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';

@Component({
 selector: 'FrontendLayoutComp',
 templateUrl: './FrontendLayoutComp.html',
 standalone: true,
 imports: [CommonModule, RouterOutlet, HeaderComp, FooterComp, MatToolbarModule, MatButtonModule, MatIconModule],
 providers: [],
})
export class FrontendLayoutComp implements OnInit {

  constructor() { }

  ngOnInit(): void { }

}