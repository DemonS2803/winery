import React from 'react';
import { Select, SelectOption, SelectList, MenuToggle, MenuToggleElement, Checkbox } from '@patternfly/react-core';

export const SelectBasic: React.FunctionComponent = (items: any[], setItem) => {
  const [isOpen, setIsOpen] = React.useState(false);
  const [isDisabled, setIsDisabled] = React.useState<boolean>(items.length == 0);
  const [selected, setSelected] = React.useState<any>(isDisabled ? 'no batches' : items[0]);

  const onToggleClick = () => {
    setIsOpen(!isOpen);
  };

  const onSelect = (_event: React.MouseEvent<Element, MouseEvent> | undefined, value: any) => {
    // eslint-disable-next-line no-console
    console.log('selected', value);

    setSelected(value);
    setIsOpen(false);
  };

  const toggle = (toggleRef: React.Ref<MenuToggleElement>) => (
    <MenuToggle
      ref={toggleRef}
      onClick={onToggleClick}
      isExpanded={isOpen}
      isDisabled={isDisabled}
      style={
        {
          width: '200px'
        } as React.CSSProperties
      }
    >
      {selected}
    </MenuToggle>
  );

  return (
    <React.Fragment>
      <Checkbox
        id="toggle-disabled"
        label="isDisabled"
        isChecked={isDisabled}
        onChange={(_event, checked) => setIsDisabled(checked)}
        style={{ marginBottom: 20 }}
      />
      <Select
        id="single-select"
        isOpen={isOpen}
        selected={selected}
        onSelect={onSelect}
        onOpenChange={(isOpen) => setIsOpen(isOpen)}
        toggle={toggle}
        shouldFocusToggleOnSelect
      >
        <SelectList>
          {items.map(item =>  <SelectOption value={item.id}>{item.id}</SelectOption>)}
        </SelectList>
      </Select>
    </React.Fragment>
  );
};
