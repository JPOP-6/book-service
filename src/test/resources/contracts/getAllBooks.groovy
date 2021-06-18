package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "return all books"
    request {
        method GET()
        url("/books/")
    }
    response {
        status OK()
        body(file("getAllBooksResponse.json"))
    }
}