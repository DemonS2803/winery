import * as React from "react";
import {PageSection, Title} from "@patternfly/react-core";
import {BatchCardList} from "@app/Batch/BatchCardList";

const Batch: React.FunctionComponent = () => (
  <PageSection>
    <Title headingLevel="h1" size="lg">All Wines</Title>
    <BatchCardList />
  </PageSection>
)

export { Batch };

