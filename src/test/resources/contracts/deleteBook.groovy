package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Delete book"
    request {
        method DELETE()
        headers {
            contentType(applicationJson())
        }
        url("/books/1")
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("deleteBookResponse.json"))
    }
}