import * as React from "react";
import {PageSection, Title} from "@patternfly/react-core";
import {AddInventorySection} from "@app/Admin/AddInventorySection";

const Admin: React.FunctionComponent = () => {
  const role = localStorage.getItem('role')
  return (
    <>
      {role === 'ADMIN'
        ?<PageSection>
          <Title headingLevel="h1" size="lg">admin page!</Title>
          <AddInventorySection />
        </PageSection>
        : <h1>no access</h1>
      }
    </>
  )
}


export { Admin };
