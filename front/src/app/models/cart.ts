import { Product } from "./product"
import { User } from "./user"

export class Cart {
    id!: number
    user!: User
    products: Product[]

    constructor(user: User, products: Product[]) {
        this.user = user
        this.products = products
    }
}
