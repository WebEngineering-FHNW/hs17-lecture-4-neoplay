package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class W3ValidatorSpec extends GebSpec {

    void "validate webpage #uri"() {
        when:"visit validator"
            go 'https://validator.w3.org'
            $("form", action: "check").uri = uri
            $("a", class: "submit").first().click()

        then:"Check result"
            title.startsWith("Showing results for")
            $("li", class: "error").size() == size

        where:
            uri | size
            'http://work.nextron.ch/2017/morath.ch/home-2017.html' | 0
            'https://www.fhnw.ch/de/startseite' | 37
    }

}
