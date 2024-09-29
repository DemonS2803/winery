import * as React from 'react';
import { PageSection, Title } from '@patternfly/react-core';
import WineCard from "@app/Wine/WineCard";

const Wine: React.FunctionComponent = () => {
  const onAdd = () => {
    console.log('add event')
  }

  return (
    <PageSection>
      <Title headingLevel="h1" size="lg">Wines list!</Title>
      <WineCard name={'wine'} type={'wine'} description={'about wine'} price={1222} onAddToCart={onAdd}/>
    </PageSection>
  )
}

export { Wine };
