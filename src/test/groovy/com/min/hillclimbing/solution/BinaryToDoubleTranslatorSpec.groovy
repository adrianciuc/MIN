package com.min.hillclimbing.solution

import spock.lang.Specification


class BinaryToDoubleTranslatorSpec extends Specification {

    def "should translate binary array to double array"() {
        given:
            def translator = new BinaryToIntegerTranslator()
            int[][] toBeTranslated = [
                    [1,0,1,0]
            ]
        when:
            int[] translated = translator.translate(toBeTranslated)
        then:
            translated.length == 1
            translated[0] == 10
    }
}
