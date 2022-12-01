import { Category } from "./category"

export class Menu {

    id: number | undefined
    name: string
    categories: Category[]

    constructor(name: string, categories: Category[]) {
        this.name = name
        this.categories = categories
    }
}
