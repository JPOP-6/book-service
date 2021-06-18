package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Add book"
    request {
        method POST()
        headers {
            contentType(applicationJson())
        }
        body(file("addBookRequest.json"))
        url("/books/")
    }
    response {
        status OK()
        body(file("addBookResponse.json"))
    }
}