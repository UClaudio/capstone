import { Category } from "./category"

export class Product {
    id: number | undefined
    name: string
    price: number
    category: Category

    constructor(name: string, price: number, category: Category) {
        this.name = name
        this.price = price
        this.category = category
    }
}
