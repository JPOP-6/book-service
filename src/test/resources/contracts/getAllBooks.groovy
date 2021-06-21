package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "return all books"
    request {
        method GET()
        headers {
            contentType(applicationJson())
        }
        url("/books/")
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("getAllBooksResponse.json"))
    }
}