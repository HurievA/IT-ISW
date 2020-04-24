let $dish := doc("result5.xml")/Array/dishes
let $count := count($dish)
return
    <lab3>
        <CountOfElements> {$count}</CountOfElements>
        <InformationFromElements>
            {
                for $elem in $dish
                return $elem/cost
            }
        </InformationFromElements>
        <InformationFromOneElement>
            {
                for $elem in $dish[1]
                return $elem/name
            }
        </InformationFromOneElement>
        <ElementsWithTwoWords>
            {
                for $elem at $count in $dish
                return $elem/$count
            }
        </ElementsWithTwoWords>
        <FistParametr>
            {
                for $elem in $dish[40]
                return $elem/*[1]
            }
        </FistParametr>
        <SecondParametr>
            {
                for $elem in $dish[40]
                return $elem/*[2]
            }
        </SecondParametr>
        <ThirdParametr>
            {
                for $elem in $dish[40]
                return $elem/*[3]
            }
        </ThirdParametr>
        <TwoParametrs>
            {
                for $elem at $count in $dish
                where $count mod 5 = 0
                return <dish>{$elem/name} {$elem/cost}</dish>
            }
        </TwoParametrs>
        <CountAndParametrOfElement>
            {
                for $elem at $count in $dish
                where $count mod 2 = 0
                return <dish>{$count} {$elem/weight}</dish>
            }
        </CountAndParametrOfElement>
        <Range>
            {
                for $elem in $dish
                where ($elem/detail/id>10000)
                        and ($elem/detail/id<15000)
                        and (matches($elem/name, "Б"))
                return $elem/name
            }
        </Range>
    </lab3>