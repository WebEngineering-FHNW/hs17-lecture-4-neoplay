package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class CalculatorSpec extends GebSpec {


    void "Basic calculation with en #enInput and exam #examInput should give result #result"() {
        when:
            go '/static/GradeCalculator.html'
        then:
        	title == "Grade Calculator"

        when: "set valid input"
            $("form").en   = enInput
            $("form").exam = examInput
            $("input", type: "submit").click()

        then: "Result Page is displayed"
            title == "Average"
            $("output").text() == result

        when: "click on back link"
            $("a", text: "calculator").click()
        then:
            title == "Grade Calculator"

        where:
            enInput | examInput | result
            4.0     | 5.0       | "4.5"
            1.0     | 3.0       | "2.0"

    }
}
