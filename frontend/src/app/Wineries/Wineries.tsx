import * as React from "react";
import {PageSection, Title} from "@patternfly/react-core";
import {WineryCardList} from "@app/Wineries/WineryCardList";

const Wineries: React.FunctionComponent = () => (
  <PageSection>
    <Title headingLevel="h1" size="lg">All My Wineries</Title>
    <WineryCardList />
  </PageSection>
)

export { Wineries };
