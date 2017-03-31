package com.min.hillclimbing.solution

import spock.lang.Specification


class BinaryToDoubleTranslatorSpec extends Specification {

    def "should translate binary array to double array"() {
        given:
            def translator = new BinaryToDoubleTranslator()
            int[][] toBeTranslated = [
                    [1,0,1,0]
            ]
        when:
            double[] translated = translator.translate(toBeTranslated)
        then:
            translated.length == 1
            translated[0] == 10.0
    }
}
