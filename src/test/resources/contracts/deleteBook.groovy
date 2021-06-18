package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Delete book"
    request {
        method DELETE()
        url("/books/1")
    }
    response {
        status OK()
        body(file("deleteBookResponse.json"))
    }
}