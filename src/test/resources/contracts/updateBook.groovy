package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Update book"
    request {
        method PUT()
        headers {
            contentType(applicationJson())
        }
        body(file("addBookRequest.json"))
        url("/books/1")
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("addBookResponse.json"))
    }
}