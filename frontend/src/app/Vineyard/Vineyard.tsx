import * as React from "react";
import {PageSection, Title} from "@patternfly/react-core";
import {WineryCardList} from "@app/Wineries/WineryCardList";
import {VineyardCardList} from "@app/Vineyard/VineyardCardList";

const Vineyard: React.FunctionComponent = () => (
  <PageSection>
    <Title headingLevel="h1" size="lg">All Vineyards</Title>
    <VineyardCardList />
  </PageSection>
)

export { Vineyard };
