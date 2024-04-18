import { Routes } from '@angular/router';
import { FrontendLayoutComp } from './frontend/layout/FrontendLayoutComp';
import { BackendLayoutComp } from './backend/layout/BackendLayoutComp';


export const routes: Routes = [
  {
    path: '',
    component: FrontendLayoutComp, //All childs pages will have headers
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', loadComponent: () => import('./frontend/home/HomeComp').then(m => m.HomeComp) },
      { path: 'contact', loadComponent: () => import('./frontend/contact/ContactComp').then(m => m.ContactComp) },
      { path: 'login', loadComponent: () => import('./frontend/login/LoginComp').then(m => m.LoginComp) },
      { path: 'register', loadComponent: () => import('./frontend/register/RegisterComp').then(m => m.RegisterComp) },
    ],
  },
  {
    path: 'admin',
    component: BackendLayoutComp, //All childs pages will have headers
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', loadComponent: () => import('./backend/admin/dashboard/DashboardComp').then(m => m.DashboardComp) },
      { path: 'category', loadComponent: () => import('./backend/admin/productCategory/ProductCategoryComp').then(m => m.ProductCategoryComp) },
      { path: 'supplier', loadComponent: () => import('./backend/admin/supplier/SupplierComp').then(m => m.SupplierComp) },
      { path: 'employee', loadComponent: () => import('./backend/admin/employee/EmployeeComp').then(m => m.EmployeeComp) },
      { path: 'expense', loadComponent: () => import('./backend/admin/expense/ExpenseComp').then(m => m.ExpenseComp) },
      { path: 'customer', loadComponent: () => import('./backend/admin/customer/CustomerComp').then(m => m.CustomerComp) },
      { path: 'payment', loadComponent: () => import('./backend/admin/payment/PaymentComp').then(m => m.PaymentComp) },
      { path: 'product', loadComponent: () => import('./backend/admin/product/ProductComp').then(m => m.ProductComp) },
      { path: 'purchase', loadComponent: () => import('./backend/admin/purchase/PurchaseComp').then(m => m.PurchaseComp) },
      { path: 'sell', loadComponent: () => import('./backend/admin/sell/SellComp').then(m => m.SellComp) },
    ],
  },
  {
    path: 'customer',
    component: BackendLayoutComp, //All childs pages will have headers
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', loadComponent: () => import('./backend/customer/dashboard/DashboardComp').then(m => m.DashboardComp) },
    ],
  },
];