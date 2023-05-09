
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ProductOrderManager from "./components/listers/ProductOrderCards"
import ProductOrderDetail from "./components/listers/ProductOrderDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import InventoryManager from "./components/listers/InventoryCards"
import InventoryDetail from "./components/listers/InventoryDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/productOrders',
                name: 'ProductOrderManager',
                component: ProductOrderManager
            },
            {
                path: '/productOrders/:id',
                name: 'ProductOrderDetail',
                component: ProductOrderDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/inventories',
                name: 'InventoryManager',
                component: InventoryManager
            },
            {
                path: '/inventories/:id',
                name: 'InventoryDetail',
                component: InventoryDetail
            },




    ]
})
