package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class FHNWSpec extends GebSpec {

    void "test home is there"() {
        when:"The home page is visited"
            go 'https://www.fhnw.ch/de/startseite'
        then:"Page title is 'FHNW — Deutsch'"
        	title == "FHNW — Deutsch"
            title.startsWith("FHNW")
    }

    void "test if 'Studium' appears in content"() {
        when:"The home page is visited"
            go 'https://www.fhnw.ch/de/startseite'
        then:"Find word 'Stuidum' on page"
            $("*", text: containsWord("Studium")).size() > 0
    }

}
