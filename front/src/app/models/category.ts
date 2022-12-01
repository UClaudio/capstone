import { Product } from "./product"

export class Category {
    id: number | undefined
    name: string
    products: Product[]

    constructor(name: string, products: Product[]){
        this.name = name
        this.products = products
    }
}
